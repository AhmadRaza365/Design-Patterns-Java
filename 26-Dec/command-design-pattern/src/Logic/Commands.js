import { Copy, Paste } from "./BusinessLogic";

// command interface

class Command {
  constructor() {
    this.name = "Command";
  }

  execute() {
    console.log("Command executed");
  }
}

// concrete command

class CopyCommand extends Command {
  copyLogic = new Copy();

  constructor() {
    super();
    this.name = "Copy";
  }

  execute() {
    this.copyLogic.copyText();
  }
}

class PasteCommand extends Command {
  pasteLogic = new Paste();
  constructor() {
    super();
    this.name = "Paste";
  }

  execute() {
    this.pasteLogic.pasteText();
  }
}

export { CopyCommand, PasteCommand };
