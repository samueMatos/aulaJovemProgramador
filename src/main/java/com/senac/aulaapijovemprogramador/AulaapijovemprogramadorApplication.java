package com.senac.aulaapijovemprogramador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AulaapijovemprogramadorApplication {

	public static void main(String[] args) {
//
//		var usuario = new Usuario();
//		usuario.setId(1L);
//		usuario.setNome("Samuel Matos");
//		usuario.setCpf(new CPF("063.720.145-20"));
//		usuario.setEmail("samuel.matos@prof.sc.senac.br");
//		usuario.setTelefone("+55048999655451");
//		System.out.println(usuario.apresentar());
//
//		var administrador = new Administrador();
//		administrador.setId(2L);
//		administrador.setNome("Administrador");
//		administrador.setCpf(new CPF("063.720.145-20"));
//		administrador.setAcessoIrrestrito(true);
//		administrador.setEmail("samuel.matos@prof.sc.senac.br");
//		administrador.setTelefone("+5504821016780");
//
//		var pedido = new Pedido();
//
//		pedido.setDescricao("Nenhuma");
//
//		System.out.println(administrador.apresentar());
//
//		NotificacaoEmail notificacaoEmail= new NotificacaoEmail(usuario.getEmail());
//
//		notificacaoEmail.Enviar("Sua senha nova é 123456!");
//
//		NotificacaoSMS notificacaoSMS = new NotificacaoSMS(administrador.getTelefone());
//
//		notificacaoSMS.Enviar("Acesso indevido!");
//
//
//		//Lista de string List.of Cria lista
//		List<String> myList = new ArrayList<>();
//		myList.add("Murialdo");
//		myList.addAll(List.of("Samuel Matos","Misael","Pedro","Luiz","Lucas"));
//
//		System.out.println("Primeiro modelo de lista");
//
//		for (String nome : myList) {
//			System.out.println(nome);
//		}
//		// Chamada de metodo
//		myList.forEach(p -> notificacaoEmail.Enviar(p));
//
//		myList.remove("Samuel Matos");
//		System.out.println("Segundo modelo modelo de lista");
//		myList.forEach(System.out::println);
//
//
//		List<Usuario> listaUsuarios = new ArrayList<>();
//
//		listaUsuarios.add(administrador);
//
//		List<Menu> menuAcessoList = new ArrayList<>();
//
//		menuAcessoList.addAll(List.of(new Menu("usuario"," O Usuario"),
//				new Menu("cadastro-empresa","Cadastro Empresa"),
//				new Menu("cadastro-pessoa","Cadastro Pessoa")));
//
//		usuario.setMenuAcesso(menuAcessoList);
//
//		listaUsuarios.add(usuario);
//
//		listaUsuarios.forEach(u -> System.out.println(u.apresentar()));
//
//		for (var u : listaUsuarios) {
//
//			if(u.getMenuAcesso() != null){
//				u.getMenuAcesso().forEach(menu -> System.out.println(menu.getDescricao()));
//			}
//			System.out.println(u.apresentar());
//		}
//
//
//		//filtro Busca 1 so
//	var usuariop =	listaUsuarios.stream()
//				.filter(u -> u.getNome().equals("Administrador")).findFirst().get();
//
//		System.out.println(usuariop.apresentar() + " Filtro");
//
//		//Filtra a lista
//		menuAcessoList.stream()
//				.filter(m-> m.getDescricao().contains("Cadastro"))
//				.filter(m-> m.getDescricao().contains("Cadastro Empresa"))
//				.toList()
//			.forEach(a -> System.out.println(a.getDescricao()));
//
//		System.out.println("Fim lista filtrada!");
//		// ordena ascendente
//		menuAcessoList.stream().sorted(Comparator.comparing(Menu::getDescricao))
//				.forEach(a-> System.out.println(a.getDescricao()));
//
//		// ordena descendente
//		menuAcessoList.stream().sorted(Comparator.comparing(Menu::getDescricao).reversed())
//				.forEach(a-> System.out.println(a.getDescricao()));
//
//
//		//Entrado a Map
//		System.out.println("Inicio do map!");
//		Map<String,Usuario> mapUsuario = new HashMap<>();
//
//		mapUsuario.put("U-1", usuario);
//		mapUsuario.put("U-2", administrador);
//		mapUsuario.put("U-3", administrador);
//		mapUsuario.put("U-4", administrador);
//		mapUsuario.put("U-5", administrador);
//
//		mapUsuario.values().forEach(u -> System.out.println(u.getNome()));
//
//		//Removendo por id
//		mapUsuario.remove("U-1");
//
//
//		mapUsuario.values().forEach(u -> System.out.println(u.getNome()));
//
//
//		//filtro map
//		System.out.println(mapUsuario.get("U-3").apresentar());
//
//		// Percorrer Chave e valor
//		for (Map.Entry<String,Usuario> u : mapUsuario.entrySet()) {
//			System.out.println(u.getKey());
//			System.out.println(u.getValue().apresentar());
//		}

		SpringApplication.run(AulaapijovemprogramadorApplication.class, args);

	}

}
