<template>
    {{ zahtev.email }}
    <br />
    {{ zahtev.telefon }}
    <br />
    {{ zahtev.poruka }}
    <br />
</template>

<script>
export default {
    name: 'ZahtevComp',
    props: ['zahtev']
}
</script>