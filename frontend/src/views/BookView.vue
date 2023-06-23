<template>
    <knjiga-comp :knjiga ="knjiga"></knjiga-comp>
</template>

<script>
import axios from 'axios'
import KnjigaComp from '../components/KnjigaComp.vue'
export default {
    name: 'BookView',
    components: {
        KnjigaComp
    },
    data() {
        return {
            knjiga: {},
            naziv: ''
        }
    },
    mounted() {
        this.naziv = this.$router.currentRoute._value.path.split('/')[2]
        console.log(this.naziv)
        axios
        .get('http://localhost:1237/api/knjige?naziv='+this.naziv)
        .then(response => {
            this.knjiga = response.data
        })
        .catch(error => {
            console.error(error)
        })
    }
}

</script>