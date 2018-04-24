var app = new Vue({
    el: "#app",
    data: {
        message: "Brasil é um bom lugar"
    },
    methods: {
        reverseMessage: function() {
            this.message = this.message.split(" ").reverse().join(" ");
        }
    }
})