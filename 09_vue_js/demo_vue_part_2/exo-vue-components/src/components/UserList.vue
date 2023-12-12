<script setup>
import { ref } from 'vue';
import UserAddForm from './UserAddForm.vue';
import UserItem from './UserItem.vue';
const userList = ref([]);

const addUserToList = (user) => {
  userList.value.push(user);
}
const editUserFromList = (user) => {
  const indexOfUser = userList.value.findIndex(e => e.id === user.id);
  userList.value[indexOfUser] = user;
}
const deleteUserFromList = (id) => {
  const indexOfUser = userList.value.findIndex(e => e.id === id);
  userList.value.splice(indexOfUser, 1);
}

</script>

<template>
  <UserAddForm @add-user="addUserToList"/>
  <table class="table w-50 text-center border">
    <thead>
      <tr>
        <th>Name</th>
        <th>Email</th>
        <th colspan="2">Actions</th>
      </tr>
    </thead>
    <tbody v-for="user in userList">
      <UserItem :user="user" :key="user.id" @edit-user="editUserFromList" @delete-user="deleteUserFromList"/>
    </tbody>
  </table>
</template>

<style scoped>

</style>
