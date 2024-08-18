import { Header } from './components/Header'
import { Sidebar } from './components/Sidebar'
import { Post } from './components/Post'
import { PostType } from './components/Post'

import styles from './App.module.css'

import './global.css'

const posts: PostType[] = [
  {
    id: 1,
    author: {
      avatarUrl: 'https://github.com/diego3g.png',
      name: 'Diego Fernandes',
      role: 'CTO @Rocketseat',
    },
    content: [
      {
        type: 'paragraph',
        content: 'Fala galeraa 👋',
      },
      {
        type: 'paragraph',
        content:
          'Acabei de subir mais um projeto no meu portifa. É um projeto que fiz no NLW Return, evento da Rocketseat. O nome do projeto é DoctorCare 🚀',
      },
      {
        type: 'link',
        content: 'jane.design/doctorcare',
      },
    ],
    publishedAt: new Date('2024-08-03 20:00:00'),
  },
  {
    id: 2,
    author: {
      avatarUrl: 'https://github.com/maykbrito.png',
      name: 'Mayk Brito',
      role: 'Educador @Rocketseat',
    },
    content: [
      {
        type: 'paragraph',
        content: 'Fala pessoal 👋',
      },
      {
        type: 'paragraph',
        content:
          'Finalmente finalizei meu novo site/portfólio. Foi um baita desafio criar todo o design e codar na unha, mas consegui 💪🏻',
      },
      {
        type: 'link',
        content: 'devonlane.design',
      },
    ],
    publishedAt: new Date('2024-08-08 20:00:00'),
  },
]

export function App() {
  return (
    <div>
      <Header />

      <div className={styles.wrapper}>
        <Sidebar></Sidebar>
        <main>
          {posts.map((post) => {
            return <Post key={post.id} post={post} />
          })}
        </main>
      </div>
    </div>
  )
}
