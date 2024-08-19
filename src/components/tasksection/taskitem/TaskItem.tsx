import styles from './TaskItem.module.css'
import { Trash, Check } from '@phosphor-icons/react'

interface TaskProps {
  id: number
  content: string
  status: boolean
}

interface TaskItemProps {
  task: TaskProps
  HandleRemoveTask: (id: number) => void
  handleToggle: (id: number, status: boolean) => void
}

export function TaskItem({
  task,
  HandleRemoveTask,
  handleToggle,
}: TaskItemProps) {
  const taskItemClassname = task.status
    ? styles['taskItemChecked']
    : styles['taskItemNotChecked']

  const paragraphCheckedClassname = task.status
    ? styles['paragraph-checked']
    : ''

  const HandleRemoveTaskItem = () => {
    HandleRemoveTask(task.id)
  }

  function handleTaskToggle(): void {
    handleToggle(task.id, !task.status)
  }

  return (
    <div className={styles.taskItem}>
      <div>
        <label htmlFor="checkbox" onClick={handleTaskToggle}>
          <input readOnly type="checkbox" checked={task.status} />
          <span className={`${styles.taskItemCheckbox} ${taskItemClassname}`}>
            {task.status && <Check size={12} />}
          </span>

          <p className={`${styles.paragraph} ${paragraphCheckedClassname}`}>
            {task.content}
          </p>
        </label>
      </div>
      <button onClick={HandleRemoveTaskItem}>
        <Trash size={16} />
      </button>
    </div>
  )
}
