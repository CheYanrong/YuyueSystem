import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: "/login"
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
	{
	  path: '/main',
	  name: 'main',
	  component: () => import('@/views/Main.vue')
	},
	{
	  path: '/login',
	  name: 'login',
	  component: () => import('@/views/LoginView.vue')
	}
  ]
})

export default router
