import styles from './TaskCounter.module.css'

export interface TaskCounterProps {
  countTasks: number
  countCompletedTasks: number
}

export function TaskCounter({
  countTasks,
  countCompletedTasks,
}: TaskCounterProps) {
  return (
    <div className={styles.taskCounter}>
      <div>
        <p>Tarefas Criadas</p>
        <span>{countTasks}</span>
      </div>
      <div>
        <p>Concluídas</p>
        <span>
          {countCompletedTasks} de {countTasks}
        </span>
      </div>
    </div>
  )
}
