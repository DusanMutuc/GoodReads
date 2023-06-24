<template>
    <korisnik-comp :korisnik ="korisnik"></korisnik-comp>
</template>

<script>
import axios from 'axios'
import KorisnikComp from '../components/KorisnikComp.vue'
export default {
    name: 'KorisnikView',
    components: {
        KorisnikComp
    },
    data() {
        return {
            korisnik: {},
            prezime: ''
        }
    },
    mounted() {
        this.prezime = this.$router.currentRoute._value.path.split('/')[2]
        console.log(this.prezime)
        axios
        .get('http://localhost:1237/api/korisnik/'+this.prezime)
        .then(response => {
            this.korisnik = response.data[0]
        })
        .catch(error => {
            console.error(error)
        })
    }
}

</script>