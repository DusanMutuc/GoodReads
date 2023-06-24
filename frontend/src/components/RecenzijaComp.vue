<template>
        <p> {{recenzija.tekst}}</p><br/>
        <p> {{recenzija.ocena}}</p><br/>
        
</template>

<script>
export default {
    name: 'RecenzijaComp',
    props: ["recenzija"]
}
</script>