<template>
    <h1>Logged in page</h1>
    <polica-comp v-for="polica in police" :key="polica.id" :polica="polica">
    </polica-comp>
    <h2>Police</h2>
    <!-- search bar za knjige -->
    <div class="searchBar">
        <input type="text" placeholder="Search books..">
    </div>
    <!-- search bar za korisnike -->
    <div class="searchBar">
        <input type="text" placeholder="Search users..">
    </div>
    <!-- pogled na zanrove -->
    <h2>Zanrovi</h2>
    <router-link to="/profile">profile</router-link><br/>
</template>

<script>
import PolicaComp from "../components/PolicaComp.vue"
export default {
    name: 'LoggedIn',
    components: {
        PolicaComp
    },
    data: function() {
        return {
            police: []
        }
    },
    mounted: function() {
        // fetch('http://localhost:1237/api/izlistajKorisnikovePolice')
        // .then(response => response.json())
        // .then(body => { this.police = body })
        // .catch(error => {
        //     console.log(error)
        // })
    },
    
}
</script>