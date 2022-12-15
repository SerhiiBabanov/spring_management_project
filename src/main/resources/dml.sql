INSERT INTO public.roles (id, role) VALUES ('4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'ROLE_USER');
INSERT INTO public.roles (id, role) VALUES ('072f378d-a7a8-44db-856a-4044668dfbe3', 'ROLE_ADMIN');

INSERT INTO public.users (id, email, password, first_name, last_name) VALUES ('e9072bc9-9402-45eb-8e9a-cc088692879c', 'admin@admin.com', '$2a$10$IskOEsfin70kKmpcsJjTdemFkPnhPEUq94mTKXY.Z1xxuROaaNf9q', 'Admin', 'Admin');

INSERT INTO public.user_roles (role_id, user_id) VALUES ('4e3c27be-76de-496a-bed2-fb2dcb71ab7a', 'e9072bc9-9402-45eb-8e9a-cc088692879c');
INSERT INTO public.user_roles (role_id, user_id) VALUES ('072f378d-a7a8-44db-856a-4044668dfbe3', 'e9072bc9-9402-45eb-8e9a-cc088692879c');

INSERT INTO public.producers (id, name) VALUES ('5e2d28db-11bd-4fff-8129-ed9f79ad288c', 'Liera');
INSERT INTO public.producers (id, name) VALUES ('7cd843f1-dc0f-4820-bc48-321096c706a7', 'Liera');
INSERT INTO public.producers (id, name) VALUES ('31910333-2be3-4500-9cbd-0b6631eb9408', 'Marqqqaa');
INSERT INTO public.producers (id, name) VALUES ('eac25cc3-86e9-4522-bb25-268a73d71c77', 'Serhii BabanovA');

INSERT INTO public.products (id, name, price, producer_id) VALUES ('194c8599-91a4-4408-839e-8eddb2941c47', 'Laravel', 10.00, '5e2d28db-11bd-4fff-8129-ed9f79ad288c');
