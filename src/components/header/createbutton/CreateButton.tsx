import { PlusCircle } from '@phosphor-icons/react'

import styles from './CreateButtom.module.css'

type Props = React.DetailedHTMLProps<
  React.ButtonHTMLAttributes<HTMLButtonElement>,
  HTMLButtonElement
>

export function CreateButton({ ...rest }: Props) {
  return (
    <div className={styles.createButton}>
      <button {...rest}>
        Criar
        <span>
          <PlusCircle size={20} weight="bold" />
        </span>
      </button>
    </div>
  )
}
