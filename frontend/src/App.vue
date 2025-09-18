<template>
  <div id="app">
    <h1>線上投票系統</h1>

    <!-- 投票項目清單 -->
    <h2>投票項目</h2>
    <table border="1">
      <tr>
        <th>編號</th>
        <th>名稱</th>
        <th>票數</th>
        <th>投票</th>
      </tr>
      <tr v-for="item in items" :key="item.id">
        <td>{{ item.id }}</td>
        <td>{{ item.name }}</td>
        <td>{{ item.votes }}</td>
        <td><button @click="vote(item.id)">投票</button></td>
      </tr>
    </table>

    <!-- 新增項目 -->
    <h2>新增投票項目</h2>
    <input v-model="newItem" placeholder="輸入項目名稱" />
    <button @click="addItem">新增</button>

    <!-- 投票者名字 -->
    <h2>設定投票人</h2>
    <input v-model="voter" placeholder="輸入你的名字" />
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'App',
  data() {
    return {
      items: [],
      newItem: '',
      voter: 'Anonymous'
    };
  },
  methods: {
    async fetchItems() {
      const res = await axios.get('http://localhost:8080/cloudvendor/items');
      this.items = res.data;
    },
    async addItem() {
      if (!this.newItem) return alert("請輸入名稱");
      await axios.post(`http://localhost:8080/cloudvendor/items?name=${this.newItem}`);
      this.newItem = '';
      this.fetchItems();
    },
    async vote(id) {
      if (!this.voter) return alert("請先輸入投票人名字");
      await axios.post(`http://localhost:8080/cloudvendor/vote?voter=${this.voter}&vendorId=${id}`);
      this.fetchItems();
    }
  },
  mounted() {
    this.fetchItems();
  }
};
</script>

<style>
#app {
  font-family: Arial, sans-serif;
  padding: 20px;
}
table {
  margin-top: 10px;
  border-collapse: collapse;
}
td, th {
  padding: 8px;
}
</style>
