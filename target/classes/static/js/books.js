//Wyświetl wczytanie z pliku i schowaj wybór
$("#file").click(
    function(){
        $("#add").css("display","none");
        $("#addFile").css("display","block");
    }
);
//Powrót do wyboru
$("#fileBack").click(
    function(){
        $("#addFile").css("display","none");
        $("#add").css("display","block");
    }
);
//Wyświetl wczytanie z formularza i schowaj wybór
$("#form").click(
    function(){
        $("#add").css("display","none");
        $("#addForm").css("display","block");
    }
);
//Powrót do wyboru
$("#formBack").click(
    function(){
        $("#addForm").css("display","none");
        $("#add").css("display","block");
    }
);