<template>
  {{}}
  <Bar class="chart" :chart-data="chartData" />
</template>

<script>
import { Bar } from "vue-chartjs";
import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale,
} from "chart.js";

ChartJS.register(
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale
);

export default {
  name: "BarChart",
  components: { Bar },
  props: { chartInfo: Object },
  data() {
    return {
    };
  },
  computed: {
    chartData() {
      return {
        labels: this.chartInfo.data.map((value) => this.formatDate(value.date)),
        datasets: [
          {
            label: "Gas consumption (liters)",
            backgroundColor: "#f87979",
            data: this.chartInfo.data.map((value) => value.value),
            barPercentage: 0.5,
            minBarLength: 2,
            
          },
        ]
      }
    }
  },

  methods: {
    formatDate(date) {
      return date.slice(8,10) + '-' + date.slice(5,7) + '-' + date.slice(0,4);
    },
  },
};
</script>

<style scoped>
.chart {
  width: 40%;
  margin:auto;
}
</style>
