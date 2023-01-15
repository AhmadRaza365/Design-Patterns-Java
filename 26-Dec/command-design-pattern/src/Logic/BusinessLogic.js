class Copy {
  constructor() {
    this.name = "Copy";
  }

  copyText() {
    document.execCommand("copy");
  }
}

class Paste {
  constructor() {
    this.name = "Paste";
  }

  async pasteText() {
    const text = await navigator.clipboard.readText();

    const textArea = document.getElementById("text-area");

    const textAreaValue = textArea.value;
    textArea.value = textAreaValue + text;
  }
}

export { Copy, Paste };