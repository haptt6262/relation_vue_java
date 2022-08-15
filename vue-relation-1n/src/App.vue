<template>
  <Navbar />
  <router-view />
</template>

<script>
import Navbar from './router/index'
export default {
  name: 'App',
  components: {
    Navbar
  }
}
</script>

<style>
</style>