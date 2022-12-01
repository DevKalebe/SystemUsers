import { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle`
  *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  body {
    background: ${(props) => props.theme.backgroundPrincipal};
  }
  button {
    cursor: pointer;
    background: transparent;
    border: none;
    transition: background-color 0.5s ease;
  }
  ul, ol {
    padding: 0;
    margin: 0;
    list-style: none;
  }
  li {
    list-style: 0;
  }
`