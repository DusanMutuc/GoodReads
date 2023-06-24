<template>
    <div v-if="this.$cookies.get('ULOGA') === 'ADMINISTRATOR'">
        <div v-for="zahtev in zahtevi" :key="zahtev.id">
            <zahtev-comp :zahtev="zahtev" />
            <!-- <button v-on:click="submit(true)" -->
        </div>
    </div>
</template>

<script>
import ZahtevComp from '../components/ZahtevComp.vue'
import axios from 'axios'
export default {
    name: 'ZahteviView',
    components: {
        ZahtevComp
    },
    data: function () {
        return {
            zahtevi: []
        }
    },
    mounted: function () {
        axios
        .get('http://localhost:1237/api/zahtevi/findAll', { withCredentials: true })
        .then(response => {
            this.zahtevi = response.data
        })
        .catch(error => { console.error(error) })
    }
}
</script>