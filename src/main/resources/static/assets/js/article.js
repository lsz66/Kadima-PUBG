var lsz = new Vue({
    el: "#page",
    data: {
        article: {}
    },
    mounted: function () {
        const id = window.location.search.substring(4);
        console.log(id);
        $.ajax({
            type: "get",
            url: "article/" + id,
            dataType: "JSON",
            success: function (data) {
                lsz.article = data;
            }
        })
    }
});