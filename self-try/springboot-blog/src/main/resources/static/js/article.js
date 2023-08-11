const deleteButton = document.getElementById("delete-button");

if (deleteButton) {
  deleteButton.addEventListener("click", () => {
    let id = document.getElementById("article-id").value;

    fetch(`/api/articles/${id}`, {
      method: "DELETE",
    }).then(() => {
      alert("삭제가 완료되었습니다.");
      location.replace("/articles");
    });
  });
}

const modifyButton = document.getElementById("modify-button");

if (modifyButton) {
  modifyButton.addEventListener("click", () => {
    let id = document.getElementById("article-id").value;

    fetch(`/api/articles/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: document.getElementById("title").value,
        content: document.getElementById("content").value,
      }),
    }).then(() => {
      alert("수정이 완료되었습니다.");
      location.replace(`/articles/${id}`);
    });
  });
}

const createButton = document.getElementById("create-button");

if (createButton) {
  createButton.addEventListener("click", () => {
    let id = document.getElementById("article-id").value;

    fetch(`/api/articles`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: document.getElementById("title").value,
        content: document.getElementById("content").value,
      }),
    }).then(() => {
      alert("등록이 완료되었습니다.");
      location.replace(`/articles`);
    });
  });
}
