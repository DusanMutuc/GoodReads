<template>
    <div v-if="this.$cookies.get('ULOGA') != null">
        <ul>
            <li v-for="polica in this.police" :key ="polica.id">
                <polica-comp :polica="polica"/>
            </li>
        </ul>
        <form>
            <label>Nova polica:</label>
            <input v-model="naziv">
            <button v-on:click="submit()">Dodaj</button>
        </form>
    </div>
</template>

<script>
import axios from 'axios'
import PolicaComp from '../components/PolicaComp.vue'
export default {
    name: 'ProfileView',
    data: function () {
        return {
            police: [],
            naziv: ''
        }
    },
    components:{
        PolicaComp
    },
    mounted: function () {
        axios
        .get('http://localhost:1237/api/izlistajKorisnikovePolice', { withCredentials: true })
        .then(response => {
            console.log(response.data)
            this.police = response.data
        })
        .catch(error => { console.error(error) })
    },
    methods: {
        submit() {
            axios
            .post('http://localhost:1237/api/korisnik/addPolica', 'naziv=' + this.naziv, {withCredentials:true})
            .catch(error => { console.log(error) })
        }
    }
}
</script>