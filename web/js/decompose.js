function popupSteps() {
    var decomposeTable = $("#decomposeTable");
    var stepInput = $("#stepInput").val();
    alert(decomposeTable);
    alert(stepInput);
    $("#decomposeTable tr:gt(2)").remove();
    var trs;
    for (var i = 1; i <= stepInput; i++) {
        var tr = "<tr>"
            +
            "<td>" + i + "step" + "<input type='hidden',name='order" + i + "' value=" + i + "/>" + "</td>"
            +
            "<td>" + "Step Name :<input type='text',name='stepName" + i + "'/>" + "<br>Step Description<textarea cols='20' rows='4' name='stepDescription" + i + "'></textarea>" + "</td>"
            +
            "</tr>"
        trs += tr;
        $("#decomposeTable").append(tr);
    }
    alert(trs);

}