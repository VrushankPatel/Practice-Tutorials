<template>
  <div>
    <div v-bind:key="todo.id" v-for="todo in todos">
      <Todoitem
        v-bind:todo="todo"
        v-on:del-todo="$emit('del-todo', todo.id)"
        @set-completed="$value => {todo.completed = $value}"
      />
    </div>
  </div>
</template>

<script>
import Todoitem from "./Todoitem.vue";

export default {
  name: "Todos",
  components: {
    Todoitem,
  },
  props: ["todos"],
};
</script>

<style scoped>
</style>