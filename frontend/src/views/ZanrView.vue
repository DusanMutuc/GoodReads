

<template>
    <knjiga-comp v-for="knjiga in knjige" :key="knjiga.id" :knjiga="knjiga"/>
</template>

<script>
import axios from 'axios'
import KnjigaComp from '../components/KnjigaComp.vue'
export default {
    name: 'ZanrView',
    components: {
        KnjigaComp
    },
    data() {
        return {
            knjige: []
        }
    },
    mounted() {
        var zanr = this.$router.currentRoute._value.path.split('/')[2];
        axios
        .get('http://localhost:1237/api/knjige/izlistajSvePoZanru?imeZanra='+ zanr)
        .then(response => {
            this.knjige = response.data
        })
        .catch(error => {
            console.error(error)
        })
    }
}

</script>