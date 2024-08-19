import { EmptyState } from './emptystate/EmptyState'
import { TaskCounter } from './taskcounter/TaskCounter'
import { TaskItem } from './taskitem/TaskItem'

import styles from './TaskSection.module.css'

export interface TaskProps {
  id: number
  content: string
  status: boolean
}

export interface Tasks {
  tasks: TaskProps[]
  removeTasK: (id: number) => void
  handleToggle: (id: number, status: boolean) => void
}

export function TaskSection({ tasks, removeTasK, handleToggle }: Tasks) {
  const HandleRemoveTask = (id: number) => {
    removeTasK(id)
  }

  const HandleTaskToggle = (id: number, status: boolean): void => {
    handleToggle(id, status)
  }

  const countCompletedTasks = tasks.filter((task) => task.status).length
  const length = tasks.length

  return (
    <section>
      <div className={styles.taskSection}>
        <TaskCounter
          countTasks={length}
          countCompletedTasks={countCompletedTasks}
        />
        {length === 0 ? (
          <EmptyState />
        ) : (
          tasks.map((task: TaskProps) => (
            <div key={task.id} className={styles.tasksList}>
              <TaskItem
                task={task}
                HandleRemoveTask={HandleRemoveTask}
                handleToggle={HandleTaskToggle}
              />
            </div>
          ))
        )}
      </div>
    </section>
  )
}
