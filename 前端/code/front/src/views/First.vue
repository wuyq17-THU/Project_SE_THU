<template>
  <div class="First">
      <div id="head">
          <Head></Head>
          <Navi></Navi>
      </div>
      
  </div>
</template>

<script>
// @ is an alias to /src
import Head from '@/components/Head.vue'
import Navi from '@/components/Navi.vue'

export default {
  name: 'First',
  components: {
    Head,
    Navi
  }
}
</script>

<style>
#head{
    margin: 0px;
    padding: 0px;

}

</style>