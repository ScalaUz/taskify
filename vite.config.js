import { defineConfig } from "vite";
import scalaJSPlugin from "@scala-js/vite-plugin-scalajs";

export default defineConfig({
  publicDir: 'public',
  plugins: [scalaJSPlugin()],
  server: {
    host: true,
    port: 4000
  }
});