<template>
  <div class="table">
    <vue-good-table :columns="columns" :rows="readings.data" max-height="400px"/>
  </div>
</template>

<script>
import "vue-good-table/dist/vue-good-table.css";
import { VueGoodTable } from "vue-good-table-next";

export default {
  name: "DataTable",
  components: { VueGoodTable },
  props: { readings: Object },

  data() {
    return {
      columns: [
        {
          label: "DeviceId",
          field: "deviceId",
          type: "number",
        },
        {
          label: "Timestamp",
          field: "timestamp",
          type: "number",
        },
        {
          label: "Value",
          field: "value",
          type: "number",
        },
      ],
    };
  },
};
</script>
<style scoped>
.table {
  width: 40%;
  height: 100%;
  max-height: fit-content;
  margin:auto;
  padding-top: 3rem;
}
</style>
