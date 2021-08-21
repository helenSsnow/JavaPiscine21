INSERT INTO public.users (id, login, password) VALUES (1, 'katya', '111');
INSERT INTO public.users (id, login, password) VALUES (2, 'masha', '111');
INSERT INTO public.users (id, login, password) VALUES (3, 'dasha', '111');
INSERT INTO public.users (id, login, password) VALUES (4, 'sasha', '111');
INSERT INTO public.users (id, login, password) VALUES (5, 'artur', '111');

INSERT INTO public.chats (id, name, userId) VALUES (1, 'aaa', 1);
INSERT INTO public.chats (id, name, userId) VALUES (2, 'bbb', 2);
INSERT INTO public.chats (id, name, userId) VALUES (3, 'ccc', 3);
INSERT INTO public.chats (id, name, userId) VALUES (4, 'ddd', 4);
INSERT INTO public.chats (id, name, userId) VALUES (5, 'eee', 5);

INSERT INTO public.messages (id, authorId, chatId, text, date) VALUES (1, 1, 1,'privet', '2021-08-19 18:27:04.000000');
INSERT INTO public.messages (id, authorId, chatId, text, date) VALUES (2, 2, 1,'privet', '2021-08-19 18:27:04.000000');
INSERT INTO public.messages (id, authorId, chatId, text, date) VALUES (3, 3, 3,'privet', '2021-08-19 18:27:04.000000');
INSERT INTO public.messages (id, authorId, chatId, text, date) VALUES (4, 4, 4,'privet', '2021-08-19 18:27:04.000000');
INSERT INTO public.messages (id, authorId, chatId, text, date) VALUES (5, 5, 3,'privet', '2021-08-19 18:27:04.000000');
