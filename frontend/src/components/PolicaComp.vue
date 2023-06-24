<template>
    <h1>{{ polica.naziv }}</h1>
    <ul>
        <li v-for="stavka in polica.stavke" :key="stavka.knjiga.Id">
            <knjiga-comp :knjiga="stavka.knjiga" />
        </li>
    </ul>
</template>

<script>
import KnjigaComp from '../components/KnjigaComp.vue'
export default {
    name: 'PolicaComp',
    props: ["polica"],
    components: {
        KnjigaComp
    }
}
</script>