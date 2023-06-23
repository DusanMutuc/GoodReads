<template>
    <div v-if = "knjiga">
        <h3>{{knjiga.naslov}}</h3><br/>
        <p>broj strana: {{knjiga.brojStrana}}</p><br/>
        <p>objavljeno: {{knjiga.datumObjavljivanja }}</p><br/>
        <p>{{knjiga.opis }}</p>
    </div>
    <div v-else>
        <h2>Knjiga ne postoji</h2>
    </div>
</template>

<script>
export default {
    name: 'KnjigaComp',
    props: ["knjiga"]
}
</script>