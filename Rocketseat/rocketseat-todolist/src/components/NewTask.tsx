import { PlusCircle } from '@phosphor-icons/react'
import styles from './NewTask.module.css'

export function NewTask() {
  return (
    <div className={styles.newTask}>
      <input type="text" placeholder="Adicione uma nova tarefa" />
      <button>
        Criar
        <span>
          <PlusCircle size={20} weight="bold" />
        </span>
      </button>
    </div>
  )
}
