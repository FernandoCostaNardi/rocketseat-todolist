import { ClipboardText } from '@phosphor-icons/react'

import styles from './ListTasks.module.css'

export function ListTasks() {
  return (
    <div className={styles.listTasks}>
      <div className={styles.listCount}>
        <div>
          <p>Tarefas Criadas</p>
          <div>
            <span>0</span>
          </div>
        </div>
        <div>
          <p>Concluídas</p>
          <div>
            <span>0</span>
          </div>
        </div>
      </div>
      <ClipboardText />
      <p>Você ainda não tem tarefas cadastradas</p>
      <p>Crie tarefas e organize seus itens a fazer</p>
    </div>
  )
}
