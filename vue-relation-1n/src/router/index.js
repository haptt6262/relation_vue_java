import { createRouter, createWebHistory } from 'vue-router'
import PostPage from '../pages/PostPage.vue'
import Test from '../components/test.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: PostPage
    },
    {
      path: '/test',
      name: 'test',
      component: Test
    },
  ]
})

export default router
