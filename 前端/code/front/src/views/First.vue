<template>
  <div class="First">
      <div id="head">
          <Head></Head>
          <Navi></Navi>
          <Step></Step>
          <Select></Select>
      </div>
      
  </div>
</template>

<script>
// @ is an alias to /src
import Head from '@/components/Head.vue'
import Navi from '@/components/Navi.vue'
import Step from '@/components/Step.vue'
import Select from '@/components/Select.vue'

export default {
  name: 'First',
  components: {
    Head,
    Navi,
    Step,
    Select
  }
}
</script>

<style>
#head{
    margin: 0px;
    padding: 0px;
}

</style>