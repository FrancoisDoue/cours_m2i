<script setup>

</script>

<template>
<header id="header-nav">
    <div>
        <a href="#">test link</a>
        <nav>
            <ul>
test
            </ul>
        </nav>
    </div>

</header>
</template>

<style scoped>

#header-nav {
    @apply border-gray-200 bg-gray-50;
    & div{
        @apply flex flex-wrap items-center justify-between mx-auto p-4;

    }
}


</style>