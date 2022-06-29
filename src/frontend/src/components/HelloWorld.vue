<template>
  <h1>{{ msg }}</h1>
</template>

<script>
import axios from 'axios';

export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
    axios.get("/api/readings").then((response) => { console.log(response)
      this.msg = response.data});
  }
}
</script>