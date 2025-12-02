# https://github.com/nix-community/nix-direnv?tab=readme-ov-file#creating-a-new-flake-native-project
{
  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
    flake-utils = {
      url = "github:numtide/flake-utils";
    };
    nix-utils = {
      url = "github:HoldenLucas/nix-utils";
    };
    gomod2nix = {
      url = "github:tweag/gomod2nix";
      inputs.nixpkgs.follows = "nixpkgs";
    };
  };

  outputs =
    {
      nixpkgs,
      flake-utils,
      nix-utils,
      gomod2nix,
      ...
    }:
    flake-utils.lib.eachDefaultSystem (
      system:
      let
        pkgs = nixpkgs.legacyPackages.${system}.extend (gomod2nix.overlays.default);

        scripts = nix-utils.lib.mkScripts pkgs (rec {
          dev = ''
            echo foo
          '';
        });

      in
      {
        devShells.default = pkgs.mkShell {
          # fixes an error with delve
          hardeningDisable = [ "fortify" ];

          packages =
            with pkgs;
            [
              go
              delve
            ]
            ++ scripts;
        };

      }
    );
}
