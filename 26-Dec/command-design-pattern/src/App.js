import { useEffect } from "react";
import { CopyCommand, PasteCommand } from "./Logic/Commands";

function App() {
  const copyByBTNClick = () => {
    const copy = new CopyCommand();
    copy.execute();
  };

  const copyByShortcut = (e) => {
    // check alt + c
    if (e.altKey && e.key === "c") {
      const copy = new CopyCommand();
      copy.execute();
    }
  };

  const pasteByBTNClick = () => {
    const paste = new PasteCommand();
    paste.execute();
  };

  const pasteByShortcut = (e) => {
    // check alt + v
    if (e.altKey && e.key === "v") {
      const paste = new PasteCommand();
      paste.execute();
    }
  };

  const checkEvent = (e) => {
    if (e.altKey && e.key === "c") {
      copyByShortcut(e);
    } else if (e.altKey && e.key === "v") {
      pasteByShortcut(e);
    }
  };

  useEffect(() => {
    document.addEventListener("keydown", checkEvent);
    return () => {
      document.removeEventListener("keydown", checkEvent);
    };
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <main className="flex flex-col items-center gap-4 justify-center py-10">
      <h1 className="text-5xl font-bold text-green-700 text-center">
        Command Design Pattern
      </h1>
      <p className="text-xl text-center text-gray-800">
        Example of the Command Design Pattern in terms of copy and paste.
      </p>

      <p className="text-xl text-center text-gray-800">
        <span className="text-2xl font-bold text-amber-700">To Copy: </span>
        Select the text and Press <span className="font-bold bg-gray-300 py-1 px-3 rounded-md">Alt + C</span> or
        click on the Copy button.
      </p>
      <p className="text-xl text-center text-gray-800">
        <span className="text-2xl font-bold text-amber-700">To Paste: </span>
        Press <span className="font-bold bg-gray-300 py-1 px-3 rounded-md">Alt + V</span> or click on the Copy
        button.
      </p>

      <div className="border-b-[1px] border-red-500 w-1/3"></div>

      <p className="w-1/2 text-center text-gray-600">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. At impedit
        commodi eius deleniti a quasi quia debitis sequi quod, necessitatibus ea
        unde consequuntur ipsa! Id, corrupti accusamus. Tempora consequatur
        ducimus autem ullam delectus beatae quod fugit deserunt pariatur
        voluptatibus laboriosam rem necessitatibus modi aperiam dignissimos
        repudiandae saepe, ut non ab, maxime libero id? Corporis deleniti sed
        velit commodi atque dolorem aut! Similique corrupti quo cum dolor hic.
        Deleniti aliquid veritatis, quae totam odit voluptatum, tenetur
        praesentium cumque officia aliquam laudantium, aperiam perspiciatis
        beatae sint. Libero debitis ab maiores perspiciatis at quod praesentium
      </p>

      <textarea
        name="text-area"
        id="text-area"
        cols="30"
        rows="10"
        className="w-6/12 h-44 border-2 border-gray-400 focus:border-gray-600 outline-none rounded-lg p-2 my-2 mx-auto"
      ></textarea>

      <div className="flex flex-row gap-4">
        <button
          className="bg-gray-700 hover:bg-gray-900 text-white font-bold py-2 px-6 rounded"
          onClick={() => {
            copyByBTNClick();
          }}
        >
          Copy
        </button>
        <button
          className="bg-gray-700 hover:bg-gray-900 text-white font-bold py-2 px-6 rounded"
          onClick={() => {
            pasteByBTNClick();
          }}
        >
          Paste
        </button>
      </div>
    </main>
  );
}

export default App;
