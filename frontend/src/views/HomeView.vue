<template>
    <h1>Home Page</h1>
    <router-link to="/login">Login</router-link><br/>
    <router-link to="/register">register</router-link><br/>
    <!-- search bar za knjige -->
    <div class="searchBar">
        <input type="text" v-model = "naziv" placeholder="Search books..">
        <button v-on:click="submit()">search book</button> <br/>
    </div>
    <!-- search bar za korisnike -->
    <div class="searchBar">
        <input type="text" v-model = "prezime" placeholder="Search users..">
        <button v-on:click="submitUser()">search user</button> <br/>
    </div>
    <!-- pogled na zanrove -->
    <h2>Zanrovi</h2>
    <ul>
        <li>
            <!-- <router-link v-for="zanr in zanrovi" :key="zanr.id" :to="'/zanr/'+zanr.naziv">{{ zanr.naziv }}</router-link> -->
            <zanr-comp v-for="zanr in zanrovi" :key="zanr.id" :zanr="zanr"/>
        </li>
    </ul>
    <form v-if="this.$cookies.get('ULOGA') === 'ADMINISTRATOR'">
        <input v-model="zanr_naziv">
        <button v-on:click="dodajZanr()">Dodaj Zanr</button>
    </form>

</template>


<script>
import ZanrComp from '../components/ZanrComp.vue'
import axios from 'axios'
export default {
    name: 'HomeView',
    components: {
        ZanrComp
    },
    data() {
        return {
            zanrovi: [],
            Knjiga: {},
            naziv: '',
            prezime: '',
            isAdmin: false,
            zanr_naziv: ''
        }
    },
    mounted() {
        axios
        .get('http://localhost:1237/api/zanrovi/findAll')
        .then(response => {
            this.zanrovi = response.data
        })
        .catch(error => {
            console.error(error)
        })
    },
    methods: {
        submit: function() {
        this.$router.push("/knjige/"+this.naziv)       
        },
        submitUser: function(){
            this.$router.push("/korisnik/"+this.prezime)
        },
        dodajZanr() {
            axios
            .post('http://localhost:1237/api/zanrovi/dodaj', 'naziv=' + this.zanr_naziv, { withCredentials: true })
            .catch(error => { console.error(error) })
        }
    }
}
</script>