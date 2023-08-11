const deleteButton = document.getElementById("delete-button");

if (deleteButton) {
  deleteButton.addEventListener("click", () => {
    let id = document.getElementById("article-id").value;

    console.log("hello");
    fetch(`/api/articles/${id}`, {
      method: "DELETE",
    }).then(() => {
      alert("삭제가 완료되었습니다.");
      location.replace("/articles");
    });
  });
}