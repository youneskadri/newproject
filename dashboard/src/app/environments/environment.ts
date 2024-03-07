
const url = window.location.href;
const formatUrl = new URL(url);
const isMobile = !formatUrl.origin.includes('localhost');
export const env = '';
export const environment = {
    host: formatUrl.origin,
    production: false,
    api: isMobile ? `${formatUrl.origin}/api` : '/api',
    env: 'LOCAL',
};
