import styles from './EmptyState.module.css'

export function EmptyState() {
  return (
    <div className={styles.emptyState}>
      <img src="/clipboard.svg" alt="Empty icon" />
      <strong>Você ainda não tem tarefas cadastradas</strong>
      <p>Crie tarefas e organize seus itens a fazer</p>
    </div>
  )
}
