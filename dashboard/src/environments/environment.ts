// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
const url = window.location.href;
const formatUrl = new URL(url);
const isMobile = !formatUrl.origin.includes('localhost');

  export const environment = {

    production: false,
    host: formatUrl.origin,
    api: isMobile ? `${formatUrl.origin}/api` : '/api',
    env: 'LOCAL',
  };
