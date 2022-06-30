<template>
  <div class="hello">
    <h1>{{ "Select a date range" }}</h1>
    <div class="datepicker">
      <Datepicker
        @update:model-value="getDataBetweenDates()"
        v-model="date"
        range
      ></Datepicker>
    </div>
    <div>
      <button :class="{button: true, disabled : !date }" @click="publishRandomValues()">
        {{ "Publish Readings" }}
      </button>
    </div>
    <div class="content">
      <BarChart :chartInfo="chartData" />
      <DataTable :readings="readings"></DataTable>
    </div>
  </div>
</template>

<script>
import BarChart from "./BarChart.vue";
import axios from "axios";
import Datepicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";
import DataTable from "./DataTable.vue";

export default {
  name: "HelloWorld",
  components: { BarChart, Datepicker, DataTable },
  props: {
    msg: String,
  },
  mounted() {
    axios.get("/api/readings").then((response) => console.log(response));
  },

  watch: {
    date: function (newVal) {
      let firstTimestamp = new Date(newVal[0]).getTime();
      let secondTimestamp = new Date(newVal[1]).getTime();
      let payload = {
        startTimestamp: firstTimestamp,
        endTimestamp: secondTimestamp,
      };
      console.log(payload);
      this.getReadingsBetween(payload);
      this.getDetailedReadingsBetween(payload);
      console.log(this.chartData.data);
    },
  },

  data() {
    return {
      chartData: {
        data: [],
      },
      readings: {
        data: [],
      },
      addReadingOpen: false,
      date: null,
    };
  },
  methods: {
    async publishRandomValues() {
      if (this.date !== null) {
        let firstTimestamp = Math.floor(Date.parse(this.date[0]));
        let secondTimestamp = Math.floor(Date.parse(this.date[1]));
        let readingsPayload = {
          startTimestamp: firstTimestamp,
          endTimestamp: secondTimestamp,
        };
        let payload = [];
        for (let i = 0; i < 10; i++) {
          payload.push({
            deviceId: this.getRndInteger(1, 10),
            timestamp: this.getRndInteger(firstTimestamp, secondTimestamp),
            value: this.getRndInteger(5, 100),
          });
        }
        await axios.post("/api/reading10", payload);
        this.getReadingsBetween(readingsPayload);
        this.getDetailedReadingsBetween(readingsPayload);
      }
    },
    getReadingsBetween(payload) {
      axios
        .get("/api/readingsBetween", { params: payload })
        .then((response) => (this.chartData.data = response.data));
    },
    getDetailedReadingsBetween(payload) {
      axios
        .get("/api/readingsBetweenDetailed", { params: payload })
        .then((response) => (this.readings.data = response.data));
      console.log(this.readings);
    },
    openAddReadings() {
      let payload = {
        startTimestamp: 1388680000000,
        endTimestamp: 1688680000000,
      };
      axios
        .get("/api/readingsBetween", { params: payload })
        .then((response) => (this.chartData.data = response.data));
      console.log(this.chartData.data);
    },
    getRndInteger(min, max) {
      return Math.floor(Math.random() * (max - min + 1)) + min;
    },
    getDataBetweenDates() {
      this.$nextTick(console.log(this.date));
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#hello {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.datepicker {
  width: 50%;
  height: auto;
  margin: auto;
}
.content {
  padding-top: 3rem;
}
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin-top:1rem;
  border-radius:25px;
  cursor: pointer;
}
.disabled {
    background-color: gray;

}
</style>
