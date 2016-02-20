function popupSteps() {
    var decomposeTable = $("#decomposeTable");
    var stepInput = $("#stepInput").val();
    //alert(decomposeTable);
    //alert(stepInput);
    $("#decomposeTable tr:gt(2)").addClass("hidden");
    //$("tr.hidden").removeClass("hidden");
    for (var i = 1; i <= stepInput; i++) {
        //alert(i);
        $("tr.hidden" + i).removeClass("hidden");
    }

}