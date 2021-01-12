<template>
  <div>
    <form @submit="addTodo" action>
      <input type="text" v-model="title" name="title" placeholder="Todo.." />
      <input type="submit" value="Submit" class="btn" />
    </form>
  </div>
</template>

<script>
// import { v4 as uuidv4 } from "uuid";

export default {
  name: "AddTodo",
  data() {
    return { title: "" };
  },
  methods: {
    addTodo(e) {
      e.preventDefault();

      if (!this.title.trim().length) return;
      const newTodo = {
        // id: uuidv4(),
        title: this.title,
        completed: false,
      };

      // send up to parent this object
      this.$emit("add-todo", newTodo);

      //clear the text box
      this.title = "";
    },
  },
};
</script>

<style scoped>
form {
  display: flex;
}
input[type="text"] {
  flex: 10;
  padding: 5px;
}
input[type="submit"] {
  flex: 2;
}
</style>