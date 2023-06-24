import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import GoodBye from '../views/GoodBye.vue'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import LoggedInView from '../views/LoggedInView.vue'
import ZanrView from '../views/ZanrView.vue'
import BookView from '../views/BookView.vue'
import KorisnikView from '../views/KorisnikView.vue'
import ProfileView from '../views/ProfileView.vue'
import ZahtevView from '../views/ZahtevView.vue'
import AutorView from '../views/AutorView.vue'
import ZahteviView from '../views/ZahteviView.vue'
import AzurirajKorisnikaView from '../views/AzurirajKorisnikaView.vue'

const routes = [
  {

    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/goodbye',
    name: 'gb',
    component: GoodBye

  },
  {
    path: '/login',
    name: 'login',
    component: LoginView

  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/logged',
    name: 'logged',
    component: LoggedInView
  },
  {
    path: '/zanr/:naziv',
    name: 'zanr',
    component: ZanrView
  },
  {
    path: '/knjige/:naziv',
    name: 'knjiga',
    component: BookView
  },
  {
    path: '/korisnik/:prezime',
    name: 'korisnik',
    component: KorisnikView
  },
  {
    path: '/profile',
    name: 'profile',
    component: ProfileView
  },
  {
    path: '/zahtev',
    name: 'zahtev',
    component: ZahtevView
  },
  {
    path: '/autor/:id',
    name: 'autor',
    component: AutorView
  },
  {
    path: '/zahtevi',
    name: 'zahtevi',
    component: ZahteviView
  },
  {
    path: '/profil/azuriraj',
    name: 'azuriraj',
    component: AzurirajKorisnikaView
  }



  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
