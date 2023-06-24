<template>
    <korisnik-comp :korisnik ="korisnik"></korisnik-comp>
    <button v-on:click="submit()">posalji zahtev za aktivaciju</button> <br/>
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
            prezime: '',
            zahtev: {}
        }
    },
    mounted() {
        axios
        .get('http://localhost:1237/api/korisnici/' + this.$router.currentRoute._value.path.split('/')[2])
        .then(response => {
            this.korisnik = response.data;
        })
        .catch(error => { console.error(error) })
    },
    methods: {
        submit() {
            this.$router.push('/zahtev?id=' + this.$router.currentRoute._value.path.split('/')[2])
        },
    }
}

</script>