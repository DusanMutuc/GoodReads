<template>
    <knjiga-comp :knjiga ="knjiga" :ocena="ocena / recenzije.length"></knjiga-comp>
    <h3>recenzije</h3>
    <recenzija-comp v-for="recenzija in recenzije" :key="recenzija.id" :recenzija ="recenzija"></recenzija-comp>
</template>

<script>
import axios from 'axios'
import KnjigaComp from '../components/KnjigaComp.vue'
import RecenzijaComp from'../components/RecenzijaComp.vue'
export default {
    name: 'BookView',
    components: {
        KnjigaComp,
        RecenzijaComp
    },
    data() {
        return {
            knjiga: {},
            naziv: '',
            recenzije: [],
            ocena: 0
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
        axios
        .get('http://localhost:1237/api/recenzije/'+this.naziv)
        .then(response=>{
            this.recenzije = response.data;

            for (let i = 0; this.recenzije.length; i++)
                this.ocena += this.recenzije[i].ocena
            this.ocena = this.ocena / this.recenzije.length
        })
        .catch(error => {
            console.error(error)
        })
    }
}

</script>