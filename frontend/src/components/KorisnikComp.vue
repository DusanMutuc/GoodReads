<template>
    <div v-if = "korisnik">
        <h3>{{korisnik.ime}} {{ korisnik.prezime }}</h3><br/>
        <p>korisnicko ime: {{korisnik.korisnickoIme}}</p><br/>
        <p>datumRodjenja: {{korisnik.datumRodjenja }}</p><br/>                                                                                                      
        <p>opis: {{korisnik.opis }}</p><br/>
        <h2>Police</h2>
        <ul>
            <li v-for="polica in korisnik.police" :key ="polica.id">
                <polica-comp :polica="polica"/>
            </li>
        </ul>
    </div>
    <div v-else>
        <h2>Korisnik ne postoji</h2>
    </div>
</template>

<script>
import PolicaComp from "../components/PolicaComp.vue"
export default {
    name: 'KorisnikComp',
    props: ["korisnik"],
    components: {PolicaComp}
}
</script>